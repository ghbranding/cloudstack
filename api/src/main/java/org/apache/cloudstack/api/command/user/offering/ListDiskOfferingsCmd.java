// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.
package org.apache.cloudstack.api.command.user.offering;

import com.cloud.offering.DiskOffering.State;
import org.apache.cloudstack.api.BaseListProjectAndAccountResourcesCmd;
import org.apache.cloudstack.api.response.StoragePoolResponse;
import org.apache.cloudstack.api.response.VolumeResponse;
import org.apache.cloudstack.api.response.ZoneResponse;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import org.apache.cloudstack.api.APICommand;
import org.apache.cloudstack.api.ApiConstants;
import org.apache.cloudstack.api.Parameter;
import org.apache.cloudstack.api.BaseCmd.CommandType;
import org.apache.cloudstack.api.response.DiskOfferingResponse;
import org.apache.cloudstack.api.response.ListResponse;

import static com.cloud.offering.DiskOffering.State.Active;

@APICommand(name = "listDiskOfferings", description = "Lists all available disk offerings.", responseObject = DiskOfferingResponse.class,
        requestHasSensitiveInfo = false, responseHasSensitiveInfo = false)
public class ListDiskOfferingsCmd extends BaseListProjectAndAccountResourcesCmd {
    public static final Logger s_logger = Logger.getLogger(ListDiskOfferingsCmd.class.getName());


    /////////////////////////////////////////////////////
    //////////////// API parameters /////////////////////
    /////////////////////////////////////////////////////

    @Parameter(name = ApiConstants.ID, type = CommandType.UUID, entityType = DiskOfferingResponse.class, description = "ID of the disk offering")
    private Long id;

    @Parameter(name = ApiConstants.NAME, type = CommandType.STRING, description = "name of the disk offering")
    private String diskOfferingName;

    @Parameter(name = ApiConstants.ZONE_ID,
            type = CommandType.UUID,
            entityType = ZoneResponse.class,
            description = "id of zone disk offering is associated with",
            since = "4.13")
    private Long zoneId;

    @Parameter(name = ApiConstants.VOLUME_ID, type = CommandType.UUID, entityType = VolumeResponse.class, description = "The ID of the volume, tags of the volume are used to filter the offerings", since = "4.17")
    private Long volumeId;

    @Parameter(name = ApiConstants.STORAGE_ID, type = CommandType.UUID, entityType = StoragePoolResponse.class, description = "The ID of the storage pool, tags of the storage pool are used to filter the offerings", since = "4.17")
    private Long storagePoolId;

    @Parameter(name = ApiConstants.ENCRYPT, type = CommandType.BOOLEAN, description = "listed offerings support disk encryption", since = "4.18")
    private Boolean encrypt;

    @Parameter(name = ApiConstants.STORAGE_TYPE,
            type = CommandType.STRING,
            description = "the storage type of the service offering. Values are local and shared.",
            since = "4.19")
    private String storageType;

    @Parameter(name = ApiConstants.STATE, type = CommandType.STRING,
               description = "Filter by state of the disk offering. Defaults to 'Active'. If set to 'all' shows both Active & Inactive offerings.",
               since = "4.19")
    private String diskOfferingState;

    /////////////////////////////////////////////////////
    /////////////////// Accessors ///////////////////////
    /////////////////////////////////////////////////////

    public Long getId() {
        return id;
    }

    public String getDiskOfferingName() {
        return diskOfferingName;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public Long getVolumeId() {
        return volumeId;
    }

    public Long getStoragePoolId() { return storagePoolId; }

    public Boolean getEncrypt() { return encrypt; }

    public String getStorageType() {
        return storageType;
    }

    public State getState() {
        if (StringUtils.isBlank(diskOfferingState)) {
            return Active;
        }
        State state = EnumUtils.getEnumIgnoreCase(State.class, diskOfferingState);
        if (!diskOfferingState.equalsIgnoreCase("all") && state == null) {
            throw new IllegalArgumentException("Invalid state value: " + diskOfferingState);
        }
        return state;
    }

    /////////////////////////////////////////////////////
    /////////////// API Implementation///////////////////
    /////////////////////////////////////////////////////

    @Override
    public void execute() {

        ListResponse<DiskOfferingResponse> response = _queryService.searchForDiskOfferings(this);
        response.setResponseName(getCommandName());
        this.setResponseObject(response);
    }
}
