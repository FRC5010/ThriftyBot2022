// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.math.kinematics.MecanumDriveOdometry;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MecanumSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  private MecanumDrive mecanumDrive;
  MecanumDriveOdometry m_odometry;

  public MecanumSubsystem(CANSparkMax frontLeft, CANSparkMax rearLeft, CANSparkMax frontRight, CANSparkMax rearRight) {
    mecanumDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
  }

  public void setDriveState(double ySpeed, double xSpeed, double rotationSpeed){
    mecanumDrive.driveCartesian(ySpeed, xSpeed, rotationSpeed);
  }

  public void stopMotors(){
    mecanumDrive.stopMotor();
  }

  @Override
  public void periodic() {
    //m_odometry.update(gyro.getRotation2d(), mecanumDrive.)
    // This method will be called once per scheduler run
  }
}
