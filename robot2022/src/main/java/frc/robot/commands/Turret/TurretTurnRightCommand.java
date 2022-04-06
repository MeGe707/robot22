
package frc.robot.commands.Turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSubsystem;


public class TurretTurnRightCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final TurretSubsystem m_turret;

  public TurretTurnRightCommand(TurretSubsystem turret){
    m_turret = turret;
    addRequirements(m_turret);
  }

  @Override
  public void initialize() {}


  @Override
  public void execute() {
      m_turret.moveTurretRight();
  }

  @Override
  public void end(boolean interrupted) {
      m_turret.stopRedline();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}