package com.mtonnicchi;

import com.mtonnicchi.numberlabeler.NumberLabeler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = Config.class)
public class NumberLabelerTest {

    @Autowired
    private NumberLabeler labeler;

    @Test
    public void basicNumbers() {
        assertThat(labeler.label("1"), equalTo("one"));
        assertThat(labeler.label("2"), equalTo("two"));
        assertThat(labeler.label("3"), equalTo("three"));
        assertThat(labeler.label("4"), equalTo("four"));
        assertThat(labeler.label("5"), equalTo("five"));
        assertThat(labeler.label("6"), equalTo("six"));
        assertThat(labeler.label("7"), equalTo("seven"));
        assertThat(labeler.label("8"), equalTo("eight"));
        assertThat(labeler.label("9"), equalTo("nine"));
        assertThat(labeler.label("10"), equalTo("ten"));
    }

    @Test
    public void trailingZeros() {
        assertThat(labeler.label("01"), equalTo("one"));
        assertThat(labeler.label("002"), equalTo("two"));
        assertThat(labeler.label("0003"), equalTo("three"));
    }

    @Test
    public void ten() {
        assertThat(labeler.label("10"), equalTo("ten"));
        assertThat(labeler.label("11"), equalTo("eleven"));
        assertThat(labeler.label("12"), equalTo("twelve"));
        assertThat(labeler.label("13"), equalTo("thirteen"));
        assertThat(labeler.label("14"), equalTo("fourteen"));
        assertThat(labeler.label("15"), equalTo("fifteen"));
        assertThat(labeler.label("16"), equalTo("sixteen"));
        assertThat(labeler.label("17"), equalTo("seventeen"));
        assertThat(labeler.label("18"), equalTo("eighteen"));
        assertThat(labeler.label("19"), equalTo("nineteen"));
        assertThat(labeler.label("20"), equalTo("twenty"));
    }

    @Test
    public void tens() {
        assertThat(labeler.label("23"), equalTo("twenty-three"));
        assertThat(labeler.label("30"), equalTo("thirty"));
        assertThat(labeler.label("45"), equalTo("forty-five"));
        assertThat(labeler.label("89"), equalTo("eighty-nine"));
    }

    @Test
    public void hundreds() {
        assertThat(labeler.label("117"), equalTo("one hundred and seventeen"));
        assertThat(labeler.label("754"), equalTo("seven hundred and fifty-four"));
        assertThat(labeler.label("981"), equalTo("nine hundred and eighty-one"));
    }

    @Test
    public void thousands() {
        assertThat(labeler.label("3000"), equalTo("three thousand"));
        assertThat(labeler.label("1092"), equalTo("one thousand and ninety-two"));
        assertThat(labeler.label("1200"), equalTo("one thousand and two hundred"));
        assertThat(labeler.label("1544"), equalTo("one thousand, five hundred and forty-four"));
        assertThat(labeler.label("10133"), equalTo("ten thousand, one hundred and thirty-three"));
        assertThat(labeler.label("17052"), equalTo("seventeen thousand and fifty-two"));
        assertThat(labeler.label("45333"), equalTo("forty-five thousand, three hundred and thirty-three"));
    }

    @Test
    public void millions() {
        assertThat(labeler.label("1000000"), equalTo("one million"));
        assertThat(labeler.label("1000012"), equalTo("one million and twelve"));
        assertThat(labeler.label("20000300"), equalTo("twenty million and three hundred"));
        assertThat(labeler.label("397005000"), equalTo("three hundred and ninety-seven million and five thousand"));
        assertThat(labeler.label("25000113"), equalTo("twenty-five million, one hundred and thirteen"));
        assertThat(labeler.label("14000700"), equalTo("fourteen million and seven hundred"));
        assertThat(labeler.label("89145723"), equalTo("eighty-nine million, one hundred and forty-five thousand, seven hundred and twenty-three"));
    }
}
