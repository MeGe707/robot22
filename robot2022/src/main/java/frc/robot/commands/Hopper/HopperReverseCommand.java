
package frc.robot.commands.Hopper;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HopperSubsystem;


public class HopperReverseCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final HopperSubsystem m_hopper;


  public HopperReverseCommand(HopperSubsystem hopper) {
    m_hopper = hopper;
    addRequirements(m_hopper);
  }

  @Override
  public void initialize() {}


  @Override
  public void execute() {
    m_hopper.reverseRedline();
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
