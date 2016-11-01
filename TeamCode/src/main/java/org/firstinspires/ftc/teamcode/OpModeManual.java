/*
Copyright (c) 2016 Shawn Wahi
*/

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="TeleOp", group="Linear Opmode")  //TODO: Change group name
@Disabled
public class OpModeManual extends LinearOpMode {

    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();
    DcMotor leftMotor = null;
    DcMotor rightMotor = null;
	DcMotor armMotorA = null; //Arm rotator motor
	DcMotor armMotorB = null; //Arm joint motor (1/2)
	DcMotor armMotorC = null; //Arm joint motor (2/2)

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        /* Initialize the hardware variables. Note that the strings used here as parameters
         * to 'get' must correspond to the names assigned during the robot configuration
         * step (using the FTC Robot Controller app on the phone).
         */
        leftMotor  = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        armMotorA = hardwareMap.dcMotor.get("arm_rotator");
        armMotorB = hardwareMap.dcMotor.get("arm_joint_1");
        armMotorC = hardwareMap.dcMotor.get("arm_joint_2");

        // Set the drive motor directions:
        // "Reverse" the motor that runs backwards when connected directly to the battery
		// TODO: Test directions of motors
        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
        armMotorA.setDirection(DcMotor.Direction.FORWARD);
        armMotorB.setDirection(DcMotor.Direction.FORWARD);
        armMotorC.setDirection(DcMotor.Direction.FORWARD);
		

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();

            // Tank controls using joystick
            // TODO: Add joystick controls for arm motors
            leftMotor.setPower(-gamepad1.left_stick_y);
            rightMotor.setPower(-gamepad1.right_stick_y);
        }
    }
}