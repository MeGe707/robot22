
package frc.robot.commands.Drive;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TeleopDriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  double getTurnJoystick;
  double getThrottleJoystick;
  private boolean getRawButton;
  private boolean slowModeActivated;
  private final DriveSubsystem m_drive;

  public TeleopDriveCommand(DriveSubsystem driveSubsystem, boolean rawButtonForSlowMode, double getThrottle, double getTurn) {
    m_drive = driveSubsystem;
    getRawButton = rawButtonForSlowMode;
    getThrottleJoystick = getThrottle;
    getTurnJoystick = getTurn;
    addRequirements(m_drive);
  }

  
  @Override
  public void initialize() {
      slowModeActivated = false;
  }

  @Override
  public void execute() {

    if(getRawButton){
        slowModeActivated =! slowModeActivated;
    }
    
    if(slowModeActivated == false){
      m_drive.curvatureDrive(getThrottleJoystick, getTurnJoystick, false);
    }
    else if(slowModeActivated){
      m_drive.curvatureDriveSlow(getThrottleJoystick, getTurnJoystick, false);
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}