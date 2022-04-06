
package frc.robot.commands.LimitBlock;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LimitBlockSubsystem;


public class LimitBlockOnCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final LimitBlockSubsystem m_limitBlock;


  public LimitBlockOnCommand(LimitBlockSubsystem limitBlock) {
    m_limitBlock = limitBlock;
    addRequirements(m_limitBlock);
  }

  @Override
  public void initialize() {}


  @Override
  public void execute() {
      m_limitBlock.openRedline();
  }


  @Override
  public void end(boolean interrupted) {
      m_limitBlock.stopRedline();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
