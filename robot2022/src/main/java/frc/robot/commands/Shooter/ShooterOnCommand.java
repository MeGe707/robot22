
package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ShooterConstants;
import frc.robot.subsystems.ShooterSubsystem;


public class ShooterOnCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShooterSubsystem m_shooter;


  public ShooterOnCommand(ShooterSubsystem shooter) {
    m_shooter = shooter;
    addRequirements(m_shooter);
  }

  @Override
  public void initialize() {
    m_shooter.resetStartTimer();
  }


  @Override
  public void execute() {
    if(m_shooter.getTimer()>=ShooterConstants.kWaitToStartSecs){
      m_shooter.openRedline();
    }
  }


  @Override
  public void end(boolean interrupted) {
      m_shooter.stopRedline();
      m_shooter.stopTimer();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
