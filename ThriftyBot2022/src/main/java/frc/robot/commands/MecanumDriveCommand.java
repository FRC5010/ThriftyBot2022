// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MecanumSubsystem;

public class MecanumDriveCommand extends CommandBase {
  /** Creates a new MecanumDrive. */
  MecanumSubsystem mecanumSubsystem;
  DoubleSupplier ySupplier, xSupplier, turnSupplier;
  public MecanumDriveCommand(MecanumSubsystem mecanumSubsystem, DoubleSupplier ySupplier, DoubleSupplier xSupplier, DoubleSupplier turnSupplier) {
    this.mecanumSubsystem = mecanumSubsystem;
    this.ySupplier = ySupplier;
    this.xSupplier = xSupplier;
    this.turnSupplier = turnSupplier;

    addRequirements(mecanumSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mecanumSubsystem.setDriveState(ySupplier.getAsDouble(), xSupplier.getAsDouble(), turnSupplier.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mecanumSubsystem.stopMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
