package com.example.testproj.models;

public class UserDataResponseBody {

    public boolean status;
    public String message;
    public Data data;

    public UserDataResponseBody() {
    }

    public UserDataResponseBody(boolean status, String message, Data data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {
        public String fullName;
        public String joiningDate;
        public String mobileNo;
        public String emailId;
        public String totalLeftTeam;
        public String totalRightTeam;
        public String totalLeftActiveTeam;
        public String totalRightActiveTeam;
        public String totalTeam;
        public String totalActiveTeam;
        public String totalInactiveTeam;
        public String totalDirects;
        public String totalActiveDirects;
        public String totalInactiveDirects;
        public String directInvestment;
        public String teamBusinessLH;
        public String teamBusinessRH;
        public String teamBusinessLM;
        public String teamBusinessRM;
        public String matchingIncome;
        public String matchingLevelIncome;
        public String directIncome;
        public String spillIncome;
        public String roiIncome;
        public String arbitrageROIIncome;
        public String levelROIIncome;
        public String levelIncome;
        public String levelROIBinbaryIncome;
        public String totalBonus;
        public String totalIncome;
        public String totalIncome_Daily;
        public String totalIncome_Weekly;
        public String mypackage;
        public String packageValue;
        public String mintingPackageValue;
        public String activationDate;
        public String walletBalance;
        public String depositWalletBalance;
        public String roiTimeRemaining_Minutes;
        public String dmB_MatchingIncome;
        public String rankIncome;
        public String superStarRoyaltyIncome;
        public String dmB_Value;
        public String currentRank;
        public String hasTopupWithMinting;
        public String arbitrageWalletBalance;
        public String capacity;

        public Data(String fullName, String joiningDate, String mobileNo, String emailId, String totalLeftTeam, String totalRightTeam, String totalLeftActiveTeam, String totalRightActiveTeam, String totalTeam, String totalActiveTeam, String totalInactiveTeam, String totalDirects, String totalActiveDirects, String totalInactiveDirects, String directInvestment, String teamBusinessLH, String teamBusinessRH, String teamBusinessLM, String teamBusinessRM, String matchingIncome, String matchingLevelIncome, String directIncome, String spillIncome, String roiIncome, String arbitrageROIIncome, String levelROIIncome, String levelIncome, String levelROIBinbaryIncome, String totalBonus, String totalIncome, String totalIncome_Daily, String totalIncome_Weekly, String mypackage, String packageValue, String mintingPackageValue, String activationDate, String walletBalance, String depositWalletBalance, String roiTimeRemaining_Minutes, String dmB_MatchingIncome, String rankIncome, String superStarRoyaltyIncome, String dmB_Value, String currentRank, String hasTopupWithMinting, String arbitrageWalletBalance, String capacity) {
            this.fullName = fullName;
            this.joiningDate = joiningDate;
            this.mobileNo = mobileNo;
            this.emailId = emailId;
            this.totalLeftTeam = totalLeftTeam;
            this.totalRightTeam = totalRightTeam;
            this.totalLeftActiveTeam = totalLeftActiveTeam;
            this.totalRightActiveTeam = totalRightActiveTeam;
            this.totalTeam = totalTeam;
            this.totalActiveTeam = totalActiveTeam;
            this.totalInactiveTeam = totalInactiveTeam;
            this.totalDirects = totalDirects;
            this.totalActiveDirects = totalActiveDirects;
            this.totalInactiveDirects = totalInactiveDirects;
            this.directInvestment = directInvestment;
            this.teamBusinessLH = teamBusinessLH;
            this.teamBusinessRH = teamBusinessRH;
            this.teamBusinessLM = teamBusinessLM;
            this.teamBusinessRM = teamBusinessRM;
            this.matchingIncome = matchingIncome;
            this.matchingLevelIncome = matchingLevelIncome;
            this.directIncome = directIncome;
            this.spillIncome = spillIncome;
            this.roiIncome = roiIncome;
            this.arbitrageROIIncome = arbitrageROIIncome;
            this.levelROIIncome = levelROIIncome;
            this.levelIncome = levelIncome;
            this.levelROIBinbaryIncome = levelROIBinbaryIncome;
            this.totalBonus = totalBonus;
            this.totalIncome = totalIncome;
            this.totalIncome_Daily = totalIncome_Daily;
            this.totalIncome_Weekly = totalIncome_Weekly;
            this.mypackage = mypackage;
            this.packageValue = packageValue;
            this.mintingPackageValue = mintingPackageValue;
            this.activationDate = activationDate;
            this.walletBalance = walletBalance;
            this.depositWalletBalance = depositWalletBalance;
            this.roiTimeRemaining_Minutes = roiTimeRemaining_Minutes;
            this.dmB_MatchingIncome = dmB_MatchingIncome;
            this.rankIncome = rankIncome;
            this.superStarRoyaltyIncome = superStarRoyaltyIncome;
            this.dmB_Value = dmB_Value;
            this.currentRank = currentRank;
            this.hasTopupWithMinting = hasTopupWithMinting;
            this.arbitrageWalletBalance = arbitrageWalletBalance;
            this.capacity = capacity;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getJoiningDate() {
            return joiningDate;
        }

        public void setJoiningDate(String joiningDate) {
            this.joiningDate = joiningDate;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getEmailId() {
            return emailId;
        }

        public void setEmailId(String emailId) {
            this.emailId = emailId;
        }

        public String getTotalLeftTeam() {
            return totalLeftTeam;
        }

        public void setTotalLeftTeam(String totalLeftTeam) {
            this.totalLeftTeam = totalLeftTeam;
        }

        public String getTotalRightTeam() {
            return totalRightTeam;
        }

        public void setTotalRightTeam(String totalRightTeam) {
            this.totalRightTeam = totalRightTeam;
        }

        public String getTotalLeftActiveTeam() {
            return totalLeftActiveTeam;
        }

        public void setTotalLeftActiveTeam(String totalLeftActiveTeam) {
            this.totalLeftActiveTeam = totalLeftActiveTeam;
        }

        public String getTotalRightActiveTeam() {
            return totalRightActiveTeam;
        }

        public void setTotalRightActiveTeam(String totalRightActiveTeam) {
            this.totalRightActiveTeam = totalRightActiveTeam;
        }

        public String getTotalTeam() {
            return totalTeam;
        }

        public void setTotalTeam(String totalTeam) {
            this.totalTeam = totalTeam;
        }

        public String getTotalActiveTeam() {
            return totalActiveTeam;
        }

        public void setTotalActiveTeam(String totalActiveTeam) {
            this.totalActiveTeam = totalActiveTeam;
        }

        public String getTotalInactiveTeam() {
            return totalInactiveTeam;
        }

        public void setTotalInactiveTeam(String totalInactiveTeam) {
            this.totalInactiveTeam = totalInactiveTeam;
        }

        public String getTotalDirects() {
            return totalDirects;
        }

        public void setTotalDirects(String totalDirects) {
            this.totalDirects = totalDirects;
        }

        public String getTotalActiveDirects() {
            return totalActiveDirects;
        }

        public void setTotalActiveDirects(String totalActiveDirects) {
            this.totalActiveDirects = totalActiveDirects;
        }

        public String getTotalInactiveDirects() {
            return totalInactiveDirects;
        }

        public void setTotalInactiveDirects(String totalInactiveDirects) {
            this.totalInactiveDirects = totalInactiveDirects;
        }

        public String getDirectInvestment() {
            return directInvestment;
        }

        public void setDirectInvestment(String directInvestment) {
            this.directInvestment = directInvestment;
        }

        public String getTeamBusinessLH() {
            return teamBusinessLH;
        }

        public void setTeamBusinessLH(String teamBusinessLH) {
            this.teamBusinessLH = teamBusinessLH;
        }

        public String getTeamBusinessRH() {
            return teamBusinessRH;
        }

        public void setTeamBusinessRH(String teamBusinessRH) {
            this.teamBusinessRH = teamBusinessRH;
        }

        public String getTeamBusinessLM() {
            return teamBusinessLM;
        }

        public void setTeamBusinessLM(String teamBusinessLM) {
            this.teamBusinessLM = teamBusinessLM;
        }

        public String getTeamBusinessRM() {
            return teamBusinessRM;
        }

        public void setTeamBusinessRM(String teamBusinessRM) {
            this.teamBusinessRM = teamBusinessRM;
        }

        public String getMatchingIncome() {
            return matchingIncome;
        }

        public void setMatchingIncome(String matchingIncome) {
            this.matchingIncome = matchingIncome;
        }

        public String getMatchingLevelIncome() {
            return matchingLevelIncome;
        }

        public void setMatchingLevelIncome(String matchingLevelIncome) {
            this.matchingLevelIncome = matchingLevelIncome;
        }

        public String getDirectIncome() {
            return directIncome;
        }

        public void setDirectIncome(String directIncome) {
            this.directIncome = directIncome;
        }

        public String getSpillIncome() {
            return spillIncome;
        }

        public void setSpillIncome(String spillIncome) {
            this.spillIncome = spillIncome;
        }

        public String getRoiIncome() {
            return roiIncome;
        }

        public void setRoiIncome(String roiIncome) {
            this.roiIncome = roiIncome;
        }

        public String getArbitrageROIIncome() {
            return arbitrageROIIncome;
        }

        public void setArbitrageROIIncome(String arbitrageROIIncome) {
            this.arbitrageROIIncome = arbitrageROIIncome;
        }

        public String getLevelROIIncome() {
            return levelROIIncome;
        }

        public void setLevelROIIncome(String levelROIIncome) {
            this.levelROIIncome = levelROIIncome;
        }

        public String getLevelIncome() {
            return levelIncome;
        }

        public void setLevelIncome(String levelIncome) {
            this.levelIncome = levelIncome;
        }

        public String getLevelROIBinbaryIncome() {
            return levelROIBinbaryIncome;
        }

        public void setLevelROIBinbaryIncome(String levelROIBinbaryIncome) {
            this.levelROIBinbaryIncome = levelROIBinbaryIncome;
        }

        public String getTotalBonus() {
            return totalBonus;
        }

        public void setTotalBonus(String totalBonus) {
            this.totalBonus = totalBonus;
        }

        public String getTotalIncome() {
            return totalIncome;
        }

        public void setTotalIncome(String totalIncome) {
            this.totalIncome = totalIncome;
        }

        public String getTotalIncome_Daily() {
            return totalIncome_Daily;
        }

        public void setTotalIncome_Daily(String totalIncome_Daily) {
            this.totalIncome_Daily = totalIncome_Daily;
        }

        public String getTotalIncome_Weekly() {
            return totalIncome_Weekly;
        }

        public void setTotalIncome_Weekly(String totalIncome_Weekly) {
            this.totalIncome_Weekly = totalIncome_Weekly;
        }

        public String getMypackage() {
            return mypackage;
        }

        public void setMypackage(String mypackage) {
            this.mypackage = mypackage;
        }

        public String getPackageValue() {
            return packageValue;
        }

        public void setPackageValue(String packageValue) {
            this.packageValue = packageValue;
        }

        public String getMintingPackageValue() {
            return mintingPackageValue;
        }

        public void setMintingPackageValue(String mintingPackageValue) {
            this.mintingPackageValue = mintingPackageValue;
        }

        public String getActivationDate() {
            return activationDate;
        }

        public void setActivationDate(String activationDate) {
            this.activationDate = activationDate;
        }

        public String getWalletBalance() {
            return walletBalance;
        }

        public void setWalletBalance(String walletBalance) {
            this.walletBalance = walletBalance;
        }

        public String getDepositWalletBalance() {
            return depositWalletBalance;
        }

        public void setDepositWalletBalance(String depositWalletBalance) {
            this.depositWalletBalance = depositWalletBalance;
        }

        public String getRoiTimeRemaining_Minutes() {
            return roiTimeRemaining_Minutes;
        }

        public void setRoiTimeRemaining_Minutes(String roiTimeRemaining_Minutes) {
            this.roiTimeRemaining_Minutes = roiTimeRemaining_Minutes;
        }

        public String getDmB_MatchingIncome() {
            return dmB_MatchingIncome;
        }

        public void setDmB_MatchingIncome(String dmB_MatchingIncome) {
            this.dmB_MatchingIncome = dmB_MatchingIncome;
        }

        public String getRankIncome() {
            return rankIncome;
        }

        public void setRankIncome(String rankIncome) {
            this.rankIncome = rankIncome;
        }

        public String getSuperStarRoyaltyIncome() {
            return superStarRoyaltyIncome;
        }

        public void setSuperStarRoyaltyIncome(String superStarRoyaltyIncome) {
            this.superStarRoyaltyIncome = superStarRoyaltyIncome;
        }

        public String getDmB_Value() {
            return dmB_Value;
        }

        public void setDmB_Value(String dmB_Value) {
            this.dmB_Value = dmB_Value;
        }

        public String getCurrentRank() {
            return currentRank;
        }

        public void setCurrentRank(String currentRank) {
            this.currentRank = currentRank;
        }

        public String getHasTopupWithMinting() {
            return hasTopupWithMinting;
        }

        public void setHasTopupWithMinting(String hasTopupWithMinting) {
            this.hasTopupWithMinting = hasTopupWithMinting;
        }

        public String getArbitrageWalletBalance() {
            return arbitrageWalletBalance;
        }

        public void setArbitrageWalletBalance(String arbitrageWalletBalance) {
            this.arbitrageWalletBalance = arbitrageWalletBalance;
        }

        public String getCapacity() {
            return capacity;
        }

        public void setCapacity(String capacity) {
            this.capacity = capacity;
        }
    }
}
