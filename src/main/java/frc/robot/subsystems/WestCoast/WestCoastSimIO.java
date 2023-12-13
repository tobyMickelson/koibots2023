// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.WestCoast;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class WestCoastSimIO implements WestCoastIO {
  private final Field2d field2d;
  private final DifferentialDrivetrainSim westCoastSim;

  private final DCMotorSim frontRighMotorSim;
  // private final EncoderSim frontRightEncoderSim;

  /** Creates a new WestCoastSim. */
  public WestCoastSimIO() {
    field2d = new Field2d();
    SmartDashboard.putData(field2d);

    frontRighMotorSim = new DCMotorSim(
      DCMotor.getNEO(1), 
      6.75, 
      0.025
    );

    westCoastSim = 
    new DifferentialDrivetrainSim (
      DCMotor.getNEO(2), 
      Constants.OUTPUT_OVER_INPUT_TORQUE, 
      Constants.ROBOT_MOMENT_OF_INERTIA, 
      Constants.ROBOT_WEIGHT_KG, 
      Constants.WHEEL_RADIUS, 
      Constants.TRACK_WIDTH, 
      null
    );
  }
}
