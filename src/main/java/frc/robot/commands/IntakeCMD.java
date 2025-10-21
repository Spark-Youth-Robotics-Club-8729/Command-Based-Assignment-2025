// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class IntakeCMD extends CommandBase {
  /** Creates a new IntakeCMD. */
  private final IntakeSubsystem intake;
  private final Joystick joystick;

  public IntakeCMD(IntakeSubsystem intake, Joystick joystick) {
    // Use addRequirements() here to declare subsystem dependencies
    this.intake = intake;
    this.joystick = joystick;
    addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    boolean intakeIn = joystick.getRawButton(1);
    boolean intakeOut = joystick.getRawButton(2);

    if (intakeIn) {
      intake.setSpeed(0.4);
    }
    else if (intakeOut) {
      intake.setSpeed(-0.4);
    }
    else {
      intake.setSpeed(intake.getStallPower());
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.setSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
