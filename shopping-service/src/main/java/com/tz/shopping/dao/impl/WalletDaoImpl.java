package com.tz.shopping.dao.impl;

import org.springframework.stereotype.Repository;

import com.tz.shopping.dao.WalletDao;
import com.tz.shopping.entity.Wallet;

@Repository("walletDao")
public class WalletDaoImpl extends BaseDaoImpl<Wallet> implements WalletDao{

}
