package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class IntakeSubsystem extends SubsystemBase {
    private final WPI_TalonSRX intakeMotor = new WPI_TalonSRX(5);
    private double lastDirection = 0;  // Track last direction for stall

    public void setIntake(double speed) {
        if (speed != 0) {
            lastDirection = Math.signum(speed);
            intakeMotor.set(speed);
        } else {
            // Apply stall power in the last known direction
            intakeMotor.set(0.2 * lastDirection);
        }
    }

    public void stop() {
        lastDirection = 0;
        intakeMotor.set(0);
    }
}