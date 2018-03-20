package com.tz.shopping.dao.impl;

import org.springframework.stereotype.Repository;

import com.tz.shopping.dao.TicketDao;
import com.tz.shopping.entity.Ticket;

@Repository("ticketDao")
public class TicketDaoImpl extends BaseDaoImpl<Ticket> implements TicketDao{

}
