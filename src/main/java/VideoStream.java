import org.json.JSONObject;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

import java.io.StringWriter;
import java.util.Date;

public class VideoStream {
    public static void main(String[] args){
        System.loadLibrary (Core.NATIVE_LIBRARY_NAME);
        Mat InputFrame=null;
        String videoURL="/home/anusha/WSO2/Git/OpenCV_PlaneDetection/resources/videos/D1.mp4";
        VideoCapture videoCapture = new VideoCapture(0);
        Date date=new Date();
        String time;
        Double FrameID=0.0;
        JSONObject object = new JSONObject();
        StringWriter out=new StringWriter();


        if (videoCapture.isOpened()){
            System.out.println("Video Loaded Successfully");

            while (true){
                videoCapture.read(InputFrame);
                if (!InputFrame.empty()) {
                    time = date.toString();
                    FrameID = FrameID + 1;

                    object.put("Time", time);
                    object.put("InputFrame", InputFrame);
                    object.put("FrameID", FrameID);
                    object.write(out);

                    String jsonText = out.toString();
                    System.out.println(jsonText);
//                String jsonString ="{Time:\'"+time+"\',InputFrame:\'"+InputFrame+"\',FrameID:\'"+FrameID+"\'}";
                }else{
                    System.out.println("Video is not found");
                }
            }
        }else{
            System.out.println("Video not found");
        }


    }


}
