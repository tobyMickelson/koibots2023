// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MidtakeSubsystem extends SubsystemBase {
    private static MidtakeSubsystem midtakeSubsystem = new MidtakeSubsystem();

    private static CANSparkMax midtakeMotor;

    public MidtakeSubsystem() {
        midtakeMotor = new CANSparkMax(Constants.Motors.MIDTAKE_MOTOR, MotorType.kBrushless);
    }

    // GETTERS

    public static MidtakeSubsystem get() {
        return midtakeSubsystem;
    }

    // SETTERS

    public void setMidtakeMotor(double speed) {
        midtakeMotor.set(speed);
    }

    // COMMANDS

    public class RunMidtakeCommand extends CommandBase {
        private double speed;

        public RunMidtakeCommand(double speed) {
            this.speed = speed;
            addRequirements(MidtakeSubsystem.this);
        }

        public RunMidtakeCommand() {
            this.speed = Constants.Motors.MIDTAKE_SPEED;
            addRequirements(MidtakeSubsystem.this);
        }

        @Override
        public void initialize() {
            MidtakeSubsystem.this.setMidtakeMotor(speed);
        }

        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public void end(boolean interrupted) {
            MidtakeSubsystem.this.setMidtakeMotor(0);
        }
    }

    public class RunReverseMidtakeCommand extends CommandBase {
        private double speed;

        public RunReverseMidtakeCommand(double speed) {
            this.speed = speed;
            addRequirements(MidtakeSubsystem.this);
        }

        public RunReverseMidtakeCommand() {
            this.speed = Constants.Motors.MIDTAKE_REVERSE_SPEED;
            addRequirements(MidtakeSubsystem.this);
        }

        @Override
        public void initialize() {
            MidtakeSubsystem.this.setMidtakeMotor(speed);
        }

        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public void end(boolean interrupted) {
            MidtakeSubsystem.this.setMidtakeMotor(0);
        }
    }

    @Override
    public void periodic() {

    }

    @Override
    public void simulationPeriodic() {

    }
}
