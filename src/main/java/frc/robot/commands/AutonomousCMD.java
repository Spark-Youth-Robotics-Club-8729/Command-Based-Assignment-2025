// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Timer;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class AutonomousCMD extends CommandBase {
  /** Creates a new AutonomousCMD. */
  private final DriveSubsystem drive;
  private final IntakeSubsystem intake;
  private final Timer timer = new Timer();

  public AutonomousCMD(DriveSubsystem drive, IntakeSubsystem intake) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.drive = drive;
    this.intake = intake;
    addRequirements(drive, intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drive.setAutoSpeed(0.5);
    intake.setAutoSpeed(0.4);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.setAutoSpeed(0);
    intake.setAutoSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.get() >= 2;
  }
}
