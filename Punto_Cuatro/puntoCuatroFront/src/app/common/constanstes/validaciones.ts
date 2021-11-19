export const ConstantesValidaciones = {
  REGEX: {
    ONLY_NUMBERS: /^\d+$/,
    ONLY_NUMBERS_10: /^[\d]{10,10}$/,
    ONLY_NUMBERS_7: /^[\d]{7,7}$/,
    ONLY_NUMBERS_INDICATIVE: /^[0-9\+]{3,3}$/,
    ONLY_NUMBERS_7_10: /^([\d]{7}|[\d]{10})$/,
    // PASSWORD: /(?=^.{8,16}$)(?=.?[A-Z])(?=.?[a-z])(?=.?[\d])(?=.?[^\sa-zA-Z0-9]).*$/,
    PASSWORD: /^(?=.\d)((?=.[a-z])||(?=.[A-Z]))(?=.[a-zA-Z]).{8,16}$/,
    EMAIL: /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/,
    ONLY_NUMBERS_DECIMAL: /^[0-9]+(\.[0-9])/,
    SPECIAL_CHARACTERS: /^[a-zA-Z0-9ñÑüÜÁÉÍÓÚáéíóú\s]+$/,
    CHARACTERS: /^[a-zA-ZñÑüÜÁÉÍÓÚáéíóú\s]+$/,
    CHARACTERS2: /(^[a-zA-Z0-9ñÑüÜÁÉÍÓÚáéíóú#\-.\s][^\&\%\$|¡!"'/=¿?'+{}\[\]\^<>;:_¬°\\¨´+~`@]$)/,
    CHARACTERS3: /(^[a-zA-Z0-9ñÑüÜÁÉÍÓÚáéíóú\-_\s]*$)/,
    CHARACTERS4: /(^[a-zA-Z0-9ñÑüÜÁÉÍÓÚáéíóú'\-_.\&\s]*$)/,
    LICENSE_PLATE: /(^[A-Z]{3}[0-9]{3})|(^[A-Z][0-9]{4}$)|(^[A-Z]{2}[0-9]{3}$)|(^[A-Z]{2}[0-9]{4})/,
    MIN_COMMISSION: /(1[0-9]+(\.)|2[0])/,
    MAX_COMMISSION: /(2[1-9]+(\.)|3[0-9]|4[0-9]|5[0])/,
    ABC_ABC: /^([A-Z\_])+$/,
    WITHOUT_SPACE: /^([A-Z0-9])+$/,
    PERCENTAGE: /^(100?|[0-9]?[0-9]|([0-9]?[0-9](\.[0-9]{1,2})))$/
  },
  PLACEHOLDER: {
    EMAIL: 'mail@example.com'
  },
  MASK: {
    // ONLY: 'd',
    ONLY_NUMBERS: 'd',
    ONLY_LETTERS: '#',
    ONLY_LETTERS_TITULAR: 's?#?',
    NUMBERS_AND_LETTERS: '%',
    DATE: '39/19/9999',
    REPEAT_DATE: 10,
    COIN: '1',
    REPEAT_DOCUMENT: 30,
    REPEAT_DOCUMENT_CONTACT: 12,
    REPEAT_NAME: 30,
    REPEAT_SURNAMES: 30,
    REPEAT_POSITION: 50,
    REPEAT_VERIFICATION_DIGIT: 1,
    REPEAT_CELLPHONE: 10,
    REPEAT_TELEPHONE: 7,
    REPEAT_NUMBER: 50,
    REPEAT_CODE_ELECTRONIC_SIGNATURE: 4,
    REPEAT_CODE_OPT: 6,
    REPEAT_COMMERCIAL_AREA: 4,
    LENGTH_CURRENT: 11,
    LENGTH_SAVING: 11,
    LENGTH_TC_MASTER: 16,
    LENGTH_TC_VISA: 16,
    LENGTH_TC_AMEX: 15,
    LENGTH_CVC_MASTER: 3,
    LENGTH_CVC_VISA: 3,
    LENGTH_CVC_AMEX: 4,
    LICENSE_PLATE: 6,
    LENGTH_CODE_ELECTRONIC_SIGNATURE: 4,
    LENGTH_MAIL: 50,
    LENGTH_TITULAR: 50,
    LENGTH_50: 50,
    LENGTH_MIN_TAG: 7,
    LENGTH_MAX_TAG: 10,
    LENGTH_MAX_PASSWORD: 16,
    LENGTH_REFERENCE: 15,
    LENGTH_CURRENCY: 11,
    LENGTH_EXTENSION: 5,
    LENGTH_FILE_PDF: "3MB",
    REPEAT_COMMISSION: 4,
    LENGTH_ADDRESS: 100,
    REPEAT_INFO_ADDRESS: 30,
    REPEAT_ADDRESS: 15
  }
}
