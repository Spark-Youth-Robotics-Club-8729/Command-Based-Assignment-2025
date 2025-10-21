package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private final CANSparkMax intakeMotor = new CANSparkMax(5, MotorType.kBrushless);
  private double lastDirection = 0;

  public IntakeSubsystem() {
    intakeMotor.restoreFactoryDefaults();
  }

  public void setSpeed(double speed) {
    intakeMotor.set(speed);

    if (speed != 0) {
      lastDirection = Math.signum(speed);
    }
  }

  public double getStallPower() {
    return 0.2 * lastDirection;
  }

  public void setAutoSpeed(double speed) {
    intakeMotor.set(speed);
  }
}