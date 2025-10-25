package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;

public class AutonomousCommand extends SequentialCommandGroup {
  /**
 * @param driveSubsystem
 * @param intakeSubsystem
 */
public AutonomousCommand(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem) {
    addCommands(
      new ParallelCommandGroup(
        new RunCommand(() -> driveSubsystem.arcadeDrive(0.5, 0), driveSubsystem).withTimeout(2),
        new RunCommand(() -> intakeSubsystem.runIntake(0.4), intakeSubsystem).withTimeout(2)
      )
    );
  }
}
