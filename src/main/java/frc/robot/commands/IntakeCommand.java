package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.OIConstants;

public class IntakeCommand extends Command {
    private final IntakeSubsystem intake;
    private final Joystick operator;

    public IntakeCommand(IntakeSubsystem intake, Joystick operator) {
        this.intake = intake;
        this.operator = operator;
        addRequirements(intake);
    }

    @Override
    public void execute() {
        boolean in = operator.getRawButton(OIConstants.INTAKE_IN_BUTTON);
        boolean out = operator.getRawButton(OIConstants.INTAKE_OUT_BUTTON);

        if (in)
            intake.run(IntakeConstants.IN_SPEED);
        else if (out)
            intake.run(IntakeConstants.OUT_SPEED);
        else
            
            intake.run(IntakeConstants.STALL_SPEED * (operator.getRawButtonReleased(OIConstants.INTAKE_OUT_BUTTON) ? -1 : 1));
    }

    @Override
    public void end(boolean interrupted) {
        intake.stop();
    }
}
