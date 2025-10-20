package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;

public class arcadedrivecommand extends Command {
    final DriveSubsystem m_drive;
    private final XboxController controller;

    public arcadedrivecommand(DriveSubsystem driveSubsystem, XboxController driverController){
       m_drive=driveSubsystem;
       controller=driverController;
       addRequirements(m_drive);

    }
    public void initialize(){

    }

    public void execute(){
        double forward = -controller.getLeftY();  // left stick Y
        double turn = controller.getRightX();     // right stick X
        m_drive.arcadeDrive(forward, turn);
    }

    public void end(boolean finished){
        m_drive.stop();
    }
    public boolean isFinished() {
        return false; // keep running until canceled or replaced
      }
}
