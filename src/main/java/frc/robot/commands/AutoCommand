package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class AutoCommand extends Command {
    private final DriveSubsystem drive;
    private final IntakeSubsystem intake;
    private final Timer timer = new Timer();

    public AutoCommand(DriveSubsystem drive, IntakeSubsystem intake) {
        this.drive = drive;
        this.intake = intake;
        addRequirements(drive, intake);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        drive.arcadeDrive(0.5, 0.0);
        intake.run(0.4);
    }

    @Override
    public void end(boolean interrupted) {
        drive.stop();
        intake.stop();
    }

    @Override
    public boolean isFinished() {
        return timer.hasElapsed(2.0);
    }
}
