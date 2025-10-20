package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


public class DriveSubsystem extends SubsystemBase{
   private final SparkMax m_frontLeftMotor = new SparkMax(DriveConstants.frontleftid, MotorType.kBrushless);
  private final SparkMax m_frontRightMotor = new SparkMax(DriveConstants.frontrightid, MotorType.kBrushless);
  private final SparkMax m_backLeftMotor = new SparkMax(DriveConstants.rearleftid, MotorType.kBrushless);
  private final SparkMax m_backRightMotor = new SparkMax(DriveConstants.rearrightid, MotorType.kBrushless);
  private final DifferentialDrive drive;
  @SuppressWarnings("removal")
private final MotorControllerGroup leftMotors = new MotorControllerGroup(m_frontLeftMotor, m_backLeftMotor);
    @SuppressWarnings("removal")
    private final MotorControllerGroup rightMotors = new MotorControllerGroup(m_frontRightMotor, m_backRightMotor);
  @SuppressWarnings("removal")
public DriveSubsystem(){
    
    rightMotors.setInverted(true);
    drive = new DifferentialDrive(leftMotors, rightMotors);

    
  }
  public void arcadeDrive(double forward, double turn){
    double fwd = Math.copySign(Math.min(Math.abs(forward), DriveConstants.maxspeedmeters), forward);
    double trn = Math.copySign(Math.min(Math.abs(turn), DriveConstants.maxangularspeed), turn);
    drive.arcadeDrive(fwd, trn);
}
  public void stop(){
    drive.stopMotor();

  }
}

