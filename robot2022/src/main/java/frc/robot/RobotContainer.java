// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.*;
import frc.robot.commands.Auto.RedObjectAutoCommand;
import frc.robot.Constants.JoystickConstants;
import frc.robot.commands.Auto.BlueObjectAutoCommand;
import frc.robot.commands.Auto.PhotonVisionDefaultCommand;
import frc.robot.commands.CommandGroups.ObjectInCommand;
import frc.robot.commands.CommandGroups.ObjectOutCommand;
import frc.robot.commands.CommandGroups.ObjectShootCommand;
import frc.robot.commands.Drive.TeleopDriveCommand;
import frc.robot.commands.Intake.SolenoidOnCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer{
  // The robot's subsystems and commands are defined here...

  public Joystick driverController = new Joystick(JoystickConstants.kDriverControllerPort);
  public Joystick operatorJoystick = new Joystick(JoystickConstants.kOperatorControllerPort);
  public final DriveSubsystem driveSubsystem = new DriveSubsystem();
  public final HopperSubsystem hopperSubsystem = new HopperSubsystem();
  public final IndexerSubsystem indexerSubsystem = new IndexerSubsystem();
  public final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  public final LimitBlockSubsystem limitBlockSubsystem = new LimitBlockSubsystem();
  public final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  public final TurretSubsystem turretSubsystem = new TurretSubsystem();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    driveSubsystem.setDefaultCommand(
      new TeleopDriveCommand(
        driveSubsystem, driverController.getRawButtonPressed(JoystickConstants.kSlowDriveButton), 
        driverController.getRawAxis(JoystickConstants.kDriveSpeedAxis), 
        driverController.getRawAxis(JoystickConstants.kDriveTurnAxis))
    );
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(driverController, Constants.JoystickConstants.kObjectInComButton).toggleWhenActive(
      new ObjectInCommand(
        hopperSubsystem, indexerSubsystem, intakeSubsystem));
    
    new JoystickButton(driverController, Constants.JoystickConstants.kObjectOutComButton).toggleWhenActive(
      new ObjectOutCommand(
        hopperSubsystem, indexerSubsystem, intakeSubsystem, limitBlockSubsystem));

    new JoystickButton(driverController, Constants.JoystickConstants.kObjectShootComButton).toggleWhenActive(
      new ObjectShootCommand(
        limitBlockSubsystem, shooterSubsystem));

    new JoystickButton(driverController, Constants.JoystickConstants.kSolenoidComButton).toggleWhenActive(
      new SolenoidOnCommand(intakeSubsystem));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand(Integer auto) {
    // An ExampleCommand will run in autonomous
    switch (auto) {
      case 1:
          return new RedObjectAutoCommand();
      case 2:
          return new BlueObjectAutoCommand();
      default:
          return new PhotonVisionDefaultCommand();
  }
  }
}