package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class autocommannd extends Command{
private DriveSubsystem m_DriveSubsystem;
private IntakeSubsystem m_IntakeSubsystem;
private final Timer timer=new Timer();

    public autocommannd(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsystem){
        m_DriveSubsystem=driveSubsystem;
        m_IntakeSubsystem=intakeSubsystem;

        addRequirements(m_DriveSubsystem,m_IntakeSubsystem);
    }
    
    public void initialize(){
        timer.restart();
    }

    public void execute(){
        m_DriveSubsystem.arcadeDrive(0.5, 0);
        m_IntakeSubsystem.intake();
    }
    public void end(boolean interrupted) {
        m_DriveSubsystem.stop();
        m_IntakeSubsystem.stop();
      }
    
      public boolean isFinished() {
        return timer.hasElapsed(2);
      }
    }

