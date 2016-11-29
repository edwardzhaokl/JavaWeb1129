package model;

import lombok.*;

/**
 * author: zhaokl
 * <p>
 * created at: 29/11/2016 18:24
 * <p>
 * desc:
 */


@Setter
@Getter
@ToString(callSuper = true)
public class MtModel{

	private long id;

	private String mtModel;

	private int validity;
}
