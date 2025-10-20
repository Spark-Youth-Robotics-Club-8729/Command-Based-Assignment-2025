package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class intakein extends Command{
    final IntakeSubsystem m_intake;
    private final XboxController controller;

    public  intakein(IntakeSubsystem intakeSubsystem, XboxController xboxController){
        m_intake=intakeSubsystem;
        controller=xboxController;
        addRequirements(m_intake);
        

    }

    public void initialize(){
    

    }

        public void execute() {
        if (controller.getRawButton(1)) {             // Button 1 = intake
            m_intake.intake();                         // full in
        } else if (controller.getRawButton(2)) {      // Button 2 = outtake
            m_intake.outtake();                     // full out
        } else if (m_intake.getMotorOutput() > 0) {   // small stall forward
            m_intake.run(0.2);
        } else if (m_intake.getMotorOutput() < 0) {   // small stall backward
            m_intake.run(-0.2);
        } else {
            m_intake.stop();                           // otherwise stop
        }
    }
    public void end(boolean interrupted) {
        m_intake.stop();
    }

    public boolean isFinished() {
        return false;  // run until canceled
    }
}


