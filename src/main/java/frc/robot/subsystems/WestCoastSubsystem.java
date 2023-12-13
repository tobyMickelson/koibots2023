// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.WestCoast.WestCoastIO;
import frc.robot.subsystems.WestCoast.WestCoastRealIO;
import frc.robot.subsystems.WestCoast.WestCoastSimIO;

public class WestCoastSubsystem extends SubsystemBase {
  private final WestCoastIO westCoastDrivetrain;
  /** Creates a new WestCoast. */
  public WestCoastSubsystem() {
    if (Robot.isReal()) {
      westCoastDrivetrain = new WestCoastRealIO (
        Constants.PRIMARY_LEFT_MOTOR_PORT, 
        Constants.PRIMARY_RIGHT_MOTOR_PORT, 
        Constants.SECONDARY_LEFT_MOTOR_PORT, 
        Constants.SECONDARY_RIGHT_MOTOR_PORT
      );
    } else {
      westCoastDrivetrain = new WestCoastSimIO();
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    
  }
}
