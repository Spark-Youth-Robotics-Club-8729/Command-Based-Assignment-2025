// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private final CANSparkMax frontLeftMotor = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax frontRightMotor = new CANSparkMax(2, MotorType.kBrushless);
  private final CANSparkMax backLeftMotor = new CANSparkMax(3, MotorType.kBrushless);
  private final CANSparkMax backRightMotor = new CANSparkMax(4, MotorType.kBrushless);
  
  private final MecanumDrive drive = new MecanumDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);

  public DriveSubsystem() {
    frontRightMotor.setInverted(true);
    backRightMotor.setInverted(true);
  }

  public void driveArcade(double forward, double turn) {
    drive.driveCartesian(0, -forward, turn);
  }

  public void setAutoSpeed(double speed) {
    frontLeftMotor.set(speed);
    frontRightMotor.set(speed);
    backLeftMotor.set(speed);
    backRightMotor.set(speed);
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
