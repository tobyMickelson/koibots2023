// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelRaceGroup;
import frc.robot.subsystems.MidtakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends ParallelRaceGroup {
    public ShooterCommand() {
        addCommands(
                ShooterSubsystem.get().new RunShooterCommand(),
                MidtakeSubsystem.get().new RunMidtakeCommand()
        );
    }

    public ShooterCommand(double speed) {
        addCommands(
                ShooterSubsystem.get().new RunShooterCommand(speed),
                MidtakeSubsystem.get().new RunMidtakeCommand()
        );
    }
}
