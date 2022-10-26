// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.function.BooleanSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.MecanumDriveCommand;
import frc.robot.subsystems.MecanumSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final Command m_autoCommand = null;

  private XboxController driver = new XboxController(0);

  private MecanumSubsystem mecanumSubsystem;

  private Gyro gyro;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    CANSparkMax frontLeft = new CANSparkMax(4, MotorType.kBrushless);
    CANSparkMax rearLeft = new CANSparkMax(6, MotorType.kBrushless);
    CANSparkMax frontRight = new CANSparkMax(3, MotorType.kBrushless);
    CANSparkMax rearRight = new CANSparkMax(5, MotorType.kBrushless);



    mecanumSubsystem = new MecanumSubsystem(frontLeft, rearLeft, frontRight, rearRight);
    

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
    mecanumSubsystem.setDefaultCommand(
      new MecanumDriveCommand(
        mecanumSubsystem, 
        () -> modifyAxis(driver.getRawAxis(1)), 
        () -> -modifyAxis(driver.getRawAxis(0)), 
        () -> modifyAxis(driver.getRawAxis(2))
        )
      );
  }

  private static double deadband(double value, double deadband) {
    if (Math.abs(value) > deadband) {
      if (value > 0.0) {
        return (value - deadband) / (1.0 - deadband);
      } else {
        return (value + deadband) / (1.0 - deadband);
      }
    } else {
      return 0.0;
    }
  }

  private static double modifyAxis(double value) {
    value = deadband(value, 0.085);
    value = Math.copySign(value * value, value);

    return value;
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    
    return m_autoCommand;
  }
}
