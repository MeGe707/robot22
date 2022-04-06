
package frc.robot.commands.Indexer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IndexerSubsystem;


public class IndexerOnCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final IndexerSubsystem m_indexer;


  public IndexerOnCommand(IndexerSubsystem indexer) {
    m_indexer = indexer;
    addRequirements(m_indexer);
  }

  @Override
  public void initialize() {}


  @Override
  public void execute() {
    m_indexer.openRedline();
  }


  @Override
  public void end(boolean interrupted) {
      m_indexer.stopRedline();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
