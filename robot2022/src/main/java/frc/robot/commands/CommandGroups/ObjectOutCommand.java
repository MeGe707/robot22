package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.Hopper.HopperReverseCommand;
import frc.robot.commands.Indexer.IndexerReverseCommand;
import frc.robot.commands.Intake.IntakeReverseCommand;
import frc.robot.commands.LimitBlock.LimitBlockReverseCommand;
import frc.robot.subsystems.HopperSubsystem;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LimitBlockSubsystem;

public class ObjectOutCommand extends ParallelCommandGroup{

    public ObjectOutCommand(HopperSubsystem hopper, IndexerSubsystem indexer, IntakeSubsystem intake, LimitBlockSubsystem limitBlock){

        addCommands(
          new IntakeReverseCommand(intake),
          new HopperReverseCommand(hopper),
          new IndexerReverseCommand(indexer),
          new LimitBlockReverseCommand(limitBlock)
          );
    }
    
}
