// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubysystem extends SubsystemBase {
  /** Creates a new ElevatorSubysystem. */
  private CANSparkMax lift;
  private RelativeEncoder liftEncoder;
  private SparkMaxPIDController liftPidController;

  private double setpoint;
  
  // GOOD EXAMPLE CODE FOR SMART MOTION
  // https://github.com/REVrobotics/SPARK-MAX-Examples/blob/master/Java/Smart%20Motion%20Example/src/main/java/frc/robot/Robot.java

  public ElevatorSubysystem(CANSparkMax lift) {
    this.lift = lift;
    this.liftEncoder = lift.getEncoder();
    liftEncoder.setPosition(0);
    this.liftPidController = lift.getPIDController();
    liftPidController.setP(Constants.liftKP);

    setpoint = 0;
  }


  public void goToPosition(double rotationPos){
    //liftPidController.setReference(setpoint, CANSparkMax.ControlType.kSmartMotion);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
