
package frc.robot.commands.Hanger;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HangerSubsystem;


public class HangerUpCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final HangerSubsystem m_hanger;


  public HangerUpCommand(HangerSubsystem hanger) {
    m_hanger = hanger;
    addRequirements(m_hanger);
  }

  @Override
  public void initialize() {}


  @Override
  public void execute() {
    m_hanger.openMotor();
  }


  @Override
  public void end(boolean interrupted) {
    m_hanger.stopMotor();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
