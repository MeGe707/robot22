
package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;


public class Robot extends TimedRobot {
  NetworkTableInstance photon = NetworkTableInstance.create();
  public static RobotState robotState;
  public static NetworkTableEntry angle;
  public static NetworkTableEntry validAngle;
  public static NetworkTableInstance inst;
  NetworkTable table = photon.getTable("photonvision").getSubTable("microsoftlifecam");
  private Command m_autonomousCommand;
  public static SendableChooser<Integer> autoChooser = new SendableChooser<>();

  public static boolean ledCanStart = false;

  private RobotContainer m_robotContainer;

  @Override
  public void robotInit() {
    m_robotContainer = new RobotContainer();

    photon.startClient("10.72.85.12");
    angle = table.getEntry("targetYaw");
    validAngle = table.getEntry("hasTarget");

    autoChooser.setDefaultOption("8 Balls Right Side", 0);
    autoChooser.addOption("3 Balls", 1);
    autoChooser.addOption("7 Balls Steal", 2);
    SmartDashboard.putData("Autonomous Selector", autoChooser);
    //robotState = RobotState.IDLE;
    //m_robotContainer.driveSubsystem.zeroHeading();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    ledCanStart = true;
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
    /**
     * if (autoChooser.getSelected() == 0) {} 
     * else if (autoChooser.getSelected() == 1) {} 
     * else if (autoChooser.getSelected() == 2) {} 
     * else {}
     */
    m_autonomousCommand = m_robotContainer.getAutonomousCommand(autoChooser.getSelected());
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }


  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();

    //m_robotContainer.driveSubsystem.resetEncoders();
    //m_robotContainer.driveSubsystem.zeroHeading();
    //m_robotContainer.driveSubsystem.resetOdometry(new Pose2d(0, 0, new Rotation2d(0)));
    }
  }

  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
    /**    public static double getVisionYawAngle() {
        return angle.getDouble(0);
    }

    public static boolean isValidAngle() {

        return validAngle.getBoolean(false);
    } */
  }

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}