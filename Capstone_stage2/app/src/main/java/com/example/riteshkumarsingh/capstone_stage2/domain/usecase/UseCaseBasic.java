package com.example.riteshkumarsingh.capstone_stage2.domain.usecase;

import com.example.riteshkumarsingh.capstone_stage2.data.source.DataRepository;

/**
 * Created by riteshkumarsingh on 05/05/17.
 */

public abstract class UseCaseBasic {
    public DataRepository mDataRepository;

    abstract void setIsFromRemote(boolean isFromCache);
}
