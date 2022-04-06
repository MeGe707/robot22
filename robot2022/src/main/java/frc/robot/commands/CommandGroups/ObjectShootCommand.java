package frc.robot.commands.CommandGroups;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.commands.LimitBlock.LimitBlockOnCommand;
import frc.robot.commands.Shooter.ShooterOnCommand;
import frc.robot.subsystems.LimitBlockSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ObjectShootCommand extends ParallelCommandGroup{

    public ObjectShootCommand(LimitBlockSubsystem limitBlock, ShooterSubsystem shooter){

        addCommands(
          new LimitBlockOnCommand(limitBlock),
          new ShooterOnCommand(shooter)
          );
    }
    
}
