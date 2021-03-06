/*************************************************************************************
 * Copyright (C) 2014-2020 GENERAL BYTES s.r.o. All rights reserved.
 *
 * This software may be distributed and modified under the terms of the GNU
 * General Public License version 2 (GPL2) as published by the Free Software
 * Foundation and appearing in the file GPL2.TXT included in the packaging of
 * this file. Please note that GPL2 Section 2[b] requires that all works based
 * on this software must also be made publicly available under the terms of
 * the GPL2 ("Copyleft").
 *
 * Contact information
 * -------------------
 *
 * GENERAL BYTES s.r.o.
 * Web      :  http://www.generalbytes.com
 *
 ************************************************************************************/

package com.generalbytes.batm.server.extensions.extra.dogecoin.wallets.blockio.dto;

public class BlockIOSigner {
    private String signer_address;
    private String signer_public_key; //in hex
    private String signed_data; //in hex

    public BlockIOSigner() {
    }

    public String getSigner_address() {
        return signer_address;
    }

    public void setSigner_address(String signer_address) {
        this.signer_address = signer_address;
    }

    public String getSigner_public_key() {
        return signer_public_key;
    }

    public void setSigner_public_key(String signer_public_key) {
        this.signer_public_key = signer_public_key;
    }

    public String getSigned_data() {
        return signed_data;
    }

    public void setSigned_data(String signed_data) {
        this.signed_data = signed_data;
    }

    @Override
    public String toString() {
        return "BlockIOSigner{" +
            "signer_address='" + signer_address + '\'' +
            ", signer_public_key='" + signer_public_key + '\'' +
            ", signed_data='" + signed_data + '\'' +
            '}';
    }
}
