
package frc.robot.commands.Hopper;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HopperSubsystem;


public class HopperOnCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final HopperSubsystem m_hopper;


  public HopperOnCommand(HopperSubsystem hopper) {
    m_hopper = hopper;
    addRequirements(m_hopper);
  }

  @Override
  public void initialize() {}


  @Override
  public void execute() {
    m_hopper.openRedline();
  }


  @Override
  public void end(boolean interrupted) {
    m_hopper.stopRedline();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
