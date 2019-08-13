
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "numbertwo", group = "3")
public class numbertwo extends OpMode {

    DcMotor frontLeft;
    DcMotor backLeft;
    DcMotor frontRight;
    DcMotor backRight;

    @Override
    public void init() {
        frontLeft = hardwareMap.dcMotor.get("fl");
        backLeft = hardwareMap.dcMotor.get("bl");
        frontRight = hardwareMap.dcMotor.get("fr");
        backRight = hardwareMap.dcMotor.get("br");

        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }
    public void loop() {
        drive(gamepad1.left_stick_x,gamepad1.left_stick_y,gamepad1.right_stick_x);

        telemetry.addData("fl: ", frontLeft.getCurrentPosition());
        telemetry.addData("fr: ", frontRight.getCurrentPosition());
        telemetry.addData("bl: ", backLeft.getCurrentPosition());
        telemetry.addData("br: ", backRight.getCurrentPosition());
    }
    public void drive(double x, double y, double z){
        double fl = -z - x + y;
        double fr = z + x + y;
        double bl = -z + x + y;
        double br = z - x + y;


        frontLeft.setPower(fl);
        frontRight.setPower(fr);
        backLeft.setPower(bl);
        backRight.setPower(br);
    }

}