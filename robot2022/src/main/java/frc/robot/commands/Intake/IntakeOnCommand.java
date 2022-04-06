
package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;


public class IntakeOnCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final IntakeSubsystem m_intake;


  public IntakeOnCommand(IntakeSubsystem intake) {
    m_intake = intake;
    addRequirements(m_intake);
  }

  @Override
  public void initialize() {}


  @Override
  public void execute() {
    m_intake.openRedline();
  }


  @Override
  public void end(boolean interrupted) {
      m_intake.stopRedline();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
