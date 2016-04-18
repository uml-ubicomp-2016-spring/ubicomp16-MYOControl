package com.example.picturegallery;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.TextView;
import android.widget.Toast;

//Thalmic methods
import com.thalmic.myo.AbstractDeviceListener;
import com.thalmic.myo.Arm;
import com.thalmic.myo.DeviceListener;
import com.thalmic.myo.Hub;
import com.thalmic.myo.Myo;
import com.thalmic.myo.Pose;
import com.thalmic.myo.Quaternion;
import com.thalmic.myo.XDirection;
import com.thalmic.myo.scanner.ScanActivity;


public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    int position = 0;

    private DeviceListener mListener = new AbstractDeviceListener() {

        @Override
        public void onConnect(Myo myo, long timestamp) {

            mTextView.setTextColor(Color.CYAN);
        }

        @Override
        public void onDisconnect(Myo myo, long timestamp) {
          mTextView.setTextColor(Color.RED);
        }

        @Override
        public void onArmSync(Myo myo, long timestamp, Arm arm, XDirection xDirection) {
            mTextView.setText(myo.getArm() == Arm.LEFT ? "Arm_left Sync" : "Arm_Right Sync");
        }

        @Override
        public void onArmUnsync(Myo myo, long timestamp) {
            mTextView.setText("MYO Unsync");
        }

        @Override
        public void onUnlock(Myo myo, long timestamp) {
            Toast.makeText(MainActivity.this, "Unlock", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onLock(Myo myo, long timestamp) {

            Toast.makeText(MainActivity.this, "Locked Myo,To Unlock double tap fingers", Toast.LENGTH_SHORT).show();

        }
        @Override
        public void onOrientationData(Myo myo, long timestamp, Quaternion rotation) {
            // Calculate Euler angles (roll, pitch, and yaw) from the quaternion.
            float roll = (float) Math.toDegrees(Quaternion.roll(rotation));
            float pitch = (float) Math.toDegrees(Quaternion.pitch(rotation));
            float yaw = (float) Math.toDegrees(Quaternion.yaw(rotation));
            // Adjust roll and pitch for the orientation of the Myo on the arm.
            if (myo.getXDirection() == XDirection.TOWARD_ELBOW) {
                roll *= -1;
                pitch *= -1;
            }
            // Next, we apply a rotation to the text view using the roll, pitch, and yaw.
            mTextView.setRotation(roll);
            mTextView.setRotationX(pitch);
            mTextView.setRotationY(yaw);
        }

        // onPose() is called whenever a Myo provides a new gesture
        @Override
        public void onPose(Myo myo, long timestamp, Pose pose) {

             switch (pose) {
                case UNKNOWN:
                    mTextView.setText("Unknown Gesture");
                    break;
                case REST:break;
                case DOUBLE_TAP:
                    String restTextId = "Double Tap";

                    switch (myo.getArm()) {
                        case LEFT:
                            restTextId = "Arm Left";
                            break;
                        case RIGHT:
                            restTextId = "Arm Right";
                            break;
                    }
                case FIST:
                    SelectedImg(position);
                    mTextView.setText("Fist Pose");//selects our image
                    break;

                case WAVE_IN: //left movt

                    position = g.getSelectedItemPosition() - 1;
                    if (position < 0)
                        return;
                    g.setSelection(position);

                    mTextView.setText("Moved Left");
                    break;

                case WAVE_OUT: //right side movt

                    position = g.getSelectedItemPosition() + 1;
                    if (position >= g.getCount())
                        return;
                    g.setSelection(position);

                    mTextView.setText("Moved Right");
                    break;
            }

                if (pose != Pose.UNKNOWN && pose != Pose.REST) {
                    // Tell the Myo to stay unlocked until told otherwise, so Myo doesn't get locked
                    myo.unlock(Myo.UnlockType.HOLD);

                    myo.notifyUserAction();
                } else {
                 myo.unlock(Myo.UnlockType.TIMED);
                }
            }
        }
        ;

        TouchImageView TmovingView;
        Gallery g;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


            Hub hub = Hub.getInstance();
            if (!hub.init(this, getPackageName())) {
                // We can't do anything with the Myo device if the Hub can't be initialized
                Toast.makeText(this, "Couldn't initialize Hub", Toast.LENGTH_SHORT).show();
                finish();
                return;
            }
            //register for DeviceListener callbacks.
            hub.addListener(mListener);

            mTextView = (TextView) findViewById(R.id.gallerytext);

            g = (Gallery) findViewById(R.id.gallery); /* find view by Id is also present inside Activity class*/
            TmovingView = (TouchImageView) findViewById(R.id.movingView1);
            g.setAdapter(new ImageAdapter(this));
            g.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView parent, View v, int position, long id) {
                    Log.v("#", String.valueOf(position)); // for console check
                         SelectedImg(position);
                         }


            });
        } //onCreate ends here

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_dash_board, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_scan) {
                onScanActionSelected();
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        private void onScanActionSelected() {
            // Launch the ScanActivity to scan for Myos to connect to.
            Intent intent = new Intent(this, ScanActivity.class);
            startActivity(intent);
        }

    private void SelectedImg(int position){

        switch (position) {
            case 0:
                Drawable myDrawable = getResources().getDrawable(R.drawable.image01);
                TmovingView.setImageDrawable(myDrawable);
                break;
            case 1:
                Drawable myDrawable1 = getResources().getDrawable(R.drawable.image02);
                TmovingView.setImageDrawable(myDrawable1);
                break;
            case 2:
                Drawable myDrawable2 = getResources().getDrawable(R.drawable.image03);
                TmovingView.setImageDrawable(myDrawable2);
                break;
                      case 3:
                          Drawable myDrawable3 = getResources().getDrawable(R.drawable.image04);
                          TmovingView.setImageDrawable(myDrawable3);  break;
			    	  case 4:
                          Drawable myDrawable4 = getResources().getDrawable(R.drawable.image05);
                          TmovingView.setImageDrawable(myDrawable4);break;
			    	  case 5:
                          Drawable myDrawable5 = getResources().getDrawable(R.drawable.image06);
                          TmovingView.setImageDrawable(myDrawable5); break;
			    	  case 6:
                          Drawable myDrawable6 = getResources().getDrawable(R.drawable.image07);
                          TmovingView.setImageDrawable(myDrawable6); break;
			    	  case 7:
                          Drawable myDrawable7 = getResources().getDrawable(R.drawable.image08);
                          TmovingView.setImageDrawable(myDrawable7); break;
			    	  case 8:
                          Drawable myDrawable8 = getResources().getDrawable(R.drawable.image09);
                          TmovingView.setImageDrawable(myDrawable8);  break;

        }


    }
 }
