package it.maggioli.eldasoft;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Dev tests")
@SelectPackages({"it.maggioli.eldasoft.appalti.bandiesitiavvisi.bl"})
public class TestSuite {

}
