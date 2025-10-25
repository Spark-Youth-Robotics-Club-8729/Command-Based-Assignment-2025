package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  private final PWMSparkMax frontLeft = new PWMSparkMax(1);
  private final PWMSparkMax frontRight = new PWMSparkMax(3);
  private final PWMSparkMax backLeft = new PWMSparkMax(2);
  private final PWMSparkMax backRight = new PWMSparkMax(4);

  public DriveSubsystem() {
    frontRight.setInverted(true);
    backRight.setInverted(true);
  }

  public void arcadeDrive(double forward, double turn) {
    double leftSpeed = forward + turn;
    double rightSpeed = forward - turn;

    frontLeft.set(leftSpeed);
    backLeft.set(leftSpeed);
    frontRight.set(rightSpeed);
    backRight.set(rightSpeed);
  }

  public void stop() {
    frontLeft.stopMotor();
    backLeft.stopMotor();
    frontRight.stopMotor();
    backRight.stopMotor();
  }
}
