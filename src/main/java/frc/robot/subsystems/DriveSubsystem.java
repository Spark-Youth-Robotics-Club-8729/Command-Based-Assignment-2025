package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveSubsystem extends SubsystemBase {
    private final WPI_TalonSRX frontLeft = new WPI_TalonSRX(1);
    private final WPI_TalonSRX backLeft = new WPI_TalonSRX(2);
    private final WPI_TalonSRX frontRight = new WPI_TalonSRX(3);
    private final WPI_TalonSRX backRight = new WPI_TalonSRX(4);

    public DriveSubsystem() {
        frontRight.setInverted(true);
        backRight.setInverted(true);
        backLeft.follow(frontLeft);
        backRight.follow(frontRight);
    }

    public void arcadeDrive(double forward, double turn) {
        double leftPower = forward + turn;
        double rightPower = forward - turn;
        frontLeft.set(leftPower);
        frontRight.set(rightPower);
    }

    public void stop() {
        frontLeft.set(0);
        frontRight.set(0);
    }
}