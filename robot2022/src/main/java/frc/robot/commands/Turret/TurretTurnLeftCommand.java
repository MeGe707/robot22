
package frc.robot.commands.Turret;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSubsystem;


public class TurretTurnLeftCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final TurretSubsystem m_turret;

  public TurretTurnLeftCommand(TurretSubsystem turret){
    m_turret = turret;
    addRequirements(m_turret);
  }

  @Override
  public void initialize() {}


  @Override
  public void execute() {
      m_turret.moveTurretLeft();
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