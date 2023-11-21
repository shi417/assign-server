package com.assign.service.waihui;

import java.math.BigDecimal;

/**
 * CurrencyService
 * Description:
 * Version:
 *
 * @author shiyaqing
 * @date 2023/11/21.
 */
public interface CurrencyService {

    BigDecimal getRate(String currencyCode);
}
