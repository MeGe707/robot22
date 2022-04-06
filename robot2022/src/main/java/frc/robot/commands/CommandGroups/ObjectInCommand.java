package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.Hopper.HopperOnCommand;
import frc.robot.commands.Indexer.IndexerOnCommand;
import frc.robot.commands.Intake.IntakeOnCommand;
import frc.robot.subsystems.HopperSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class ObjectInCommand extends ParallelCommandGroup{
    
    public ObjectInCommand(HopperSubsystem hopper, IndexerSubsystem indexer, IntakeSubsystem intake){
        addCommands(
          new IntakeOnCommand(intake),
          new HopperOnCommand(hopper),
          new IndexerOnCommand(indexer)
          );
    }
    
}
