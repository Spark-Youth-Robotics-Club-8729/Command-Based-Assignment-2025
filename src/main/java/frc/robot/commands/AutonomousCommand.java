package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class AutonomousCommand extends SequentialCommandGroup {
    public AutonomousCommand(DriveSubsystem drive, IntakeSubsystem intake) {
        addCommands(
            new ParallelCommandGroup(
                new RunCommand(() -> drive.arcadeDrive(0.5, 0), drive),
                new RunCommand(() -> intake.setIntake(0.4), intake)
            ).withTimeout(2.0),
            new RunCommand(() -> {
                drive.stop();
                intake.stop();
            })
        );
    }
}